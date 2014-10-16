package pl.pragmatists.atm.unit.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.pragmatists.atm.app.Application;
import pl.pragmatists.atm.controllers.WithdrawController;

@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class WithdrawControllerTest {

    @Autowired
    private WithdrawController withdrawController;

    @Test
    public void withdraw() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(withdrawController).build();
        mockMvc.perform(MockMvcRequestBuilders.post("/withdraw"))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}