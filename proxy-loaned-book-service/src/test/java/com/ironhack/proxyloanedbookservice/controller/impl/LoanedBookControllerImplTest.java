package com.ironhack.proxyloanedbookservice.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ironhack.proxyloanedbookservice.controller.dto.LoanStateDTO;
import com.ironhack.proxyloanedbookservice.controller.dto.LoanedDTO;
import com.ironhack.proxyloanedbookservice.controller.dto.PickUpDTO;
import com.ironhack.proxyloanedbookservice.enums.LOAN_STATE;
import com.ironhack.proxyloanedbookservice.enums.PICKED_UP;
import com.ironhack.proxyloanedbookservice.models.LoanedBook;
import com.ironhack.proxyloanedbookservice.repository.LoanedBookRepository;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@AutoConfigureMockMvc
class LoanedBookControllerImplTest {
    @Autowired
    private MockMvc mockMvc; // Simular peticiones HTTP
    private final ObjectMapper objectMapper = new ObjectMapper(); // Contruir Objetos JSON a partir de clase de JAVA

    @Autowired
    LoanedBookRepository loanedBookRepository;

    private LoanedBook loanedBook1, loanedBook2, loanedBook3, loanedBook4;
    private LoanedDTO loanedDTO1;

    java.time.LocalDate localDate1 = java.time.LocalDate.of(2020, 01, 01);
    java.time.LocalDate localDate2 = java.time.LocalDate.of(2020, 01, 02);

    @BeforeEach
    void setUp() {
        loanedBook1 = new LoanedBook(324324L, LOAN_STATE.AVAILABLE,localDate1, localDate2,
                PICKED_UP.NO, null);
        loanedBook2 = new LoanedBook(435789L, LOAN_STATE.LOANED,localDate1, localDate2,
                PICKED_UP.NO, 1L);
        loanedBook3 = new LoanedBook(9856L, LOAN_STATE.LOST,localDate1, localDate2,
                PICKED_UP.NO, null);
        loanedBook4 = new LoanedBook(1231223L, LOAN_STATE.OVERDUE,localDate1, localDate2,
                PICKED_UP.NO, null);
        loanedBookRepository.saveAll(Arrays.asList(loanedBook1, loanedBook2, loanedBook3, loanedBook4));
        loanedDTO1 = new LoanedDTO(324324L, 1L);
    }

    @AfterEach
    void tearDown() {
        loanedBookRepository.deleteAll();
    }

    @Test
    void loaningBook() throws Exception {
        String json = objectMapper.writeValueAsString(loanedDTO1);

        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post("/loanedBooks")
                        .contentType("application/json")
                        .content(json))
                .andReturn();

        assertEquals(201, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.LOANED.toString()));
    }

  @Test
    void returnBook() throws Exception {
      MvcResult result = mockMvc.perform(
              org.springframework.test.web.servlet.request
                      .MockMvcRequestBuilders.get("/loanedBooks/return/"+ loanedBook2.getEan()))
              .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.AVAILABLE.toString()));

    }


    @Test
    void createLoanedBookRegister() throws Exception {
        Long ean = 3434324L;

        String json = objectMapper.writeValueAsString(ean);

        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post("/loanedBooks/create")
                        .contentType("application/json")
                        .content(json))
                .andReturn();
        assertEquals(201, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.AVAILABLE.toString()));

    }

    @Test
    void findAllLoanedBooks() throws Exception {
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/loanedBooks"))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.AVAILABLE.toString()));
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.LOANED.toString()));
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.LOST.toString()));
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.OVERDUE.toString()));

    }

    @Test
    void findByEan() throws Exception {
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .get("/loanedBooks/"+ loanedBook1.getEan()))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.AVAILABLE.toString()));
        assertTrue(result.getResponse().getContentAsString().contains(PICKED_UP.NO.toString()));
    }

    @Test
    void findByUserId() throws Exception {
    MvcResult result = mockMvc.perform(
            org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                    .get("/loanedBooks/user/1"))
            .andReturn();

        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.LOANED.toString()));
        assertTrue(result.getResponse().getContentAsString().contains(PICKED_UP.NO.toString()));
        assertTrue(result.getResponse().getContentAsString().contains(loanedBook2.getEan().toString()));
    }

    @Test
    void findByLoanState_Available() throws Exception {
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .get("/loanedBooks/available"))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.AVAILABLE.toString()));
        assertTrue(result.getResponse().getContentAsString().contains(loanedBook1.getEan().toString()));

    }

    @Test
    void findByLoanState_Lost() throws Exception {
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .get("/loanedBooks/lost"))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.LOST.toString()));
        assertTrue(result.getResponse().getContentAsString().contains(loanedBook3.getEan().toString()));
    }

    @Test
    void findByLoanState_Loaned() throws Exception {
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .get("/loanedBooks/loaned"))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.LOANED.toString()));
        assertTrue(result.getResponse().getContentAsString().contains(loanedBook2.getEan().toString()));
    }

    @Test
    void findByLoanState_Overdue() throws Exception {
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .get("/loanedBooks/overdue"))
                .andReturn();
        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.OVERDUE.toString()));
        assertTrue(result.getResponse().getContentAsString().contains(loanedBook4.getEan().toString()));
    }

    @Test
    void updateStatus() throws Exception {
        String json = objectMapper.writeValueAsString(new LoanStateDTO(LOAN_STATE.LOST));
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .patch("/loanedBooks/"+loanedBook1.getEan()+"/status")
                .contentType("application/json")
                .content(json))
                .andReturn();

        assertEquals(204, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.LOST.toString()));

    }

    @Test
    void updateStatusLoans() throws Exception {
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .get("/loanedBooks/status"))
                .andReturn();

        assertEquals(204, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(LOAN_STATE.OVERDUE.toString()));
        assertFalse(result.getResponse().getContentAsString().contains(LOAN_STATE.LOST.toString()));
        assertFalse(result.getResponse().getContentAsString().contains(LOAN_STATE.AVAILABLE.toString()));
        assertFalse(result.getResponse().getContentAsString().contains(LOAN_STATE.LOANED.toString()));
    }
/*    @PutMapping("/loanedBooks/pickUp/{ean}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public LoanedBook updatePickUp(@PathVariable Long ean, @RequestBody PickUpDTO pickUpDTO) {
        return loanedBookRepository.save(loanedBookService.updatePickUp(pickUpDTO.getEan()));
    }
*/
    @Test
    void updatePickUp() throws Exception {
        String json = objectMapper.writeValueAsString(new PickUpDTO(loanedBook1.getEan()));
        MvcResult result = mockMvc.perform(
                org.springframework.test.web.servlet.request.MockMvcRequestBuilders
                        .put("/loanedBooks/pickUp/" + loanedBook1.getEan())
                .contentType("application/json")
                .content(json))
                .andReturn();
        assertEquals(204, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains(PICKED_UP.YES.toString()));
    }
}
