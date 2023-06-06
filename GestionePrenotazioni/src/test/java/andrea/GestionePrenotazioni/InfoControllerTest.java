package andrea.GestionePrenotazioni;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import andrea.GestionePrenotazioni.controllers.InfoController;

@WebMvcTest(InfoController.class)
public class InfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomeEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/info"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Inserisci /it per le info in italiano || Insert /en for english language info"));
    }

    @Test
    public void testHomeItEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/info/it"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Benvenuto, a seguire le regole per la prenotazione: ..."));
    }

    @Test
    public void testHomeEnEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/info/en"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Welcome, here you are our reservation rules: ..."));
    }
}
