package guru.springframework.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

public class IndexControllerTest {

  @Mock
  private RecipeService recipeService;

  @Mock
  private Model model;

  private IndexController indexController;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    this.indexController = new IndexController(this.recipeService);
  }

  @Test
  public void getIndexPage() {
    String viewName = this.indexController.getIndexPage(this.model);

    assertEquals("index", viewName);
    verify(this.recipeService).getRecipes();
    verify(this.model).addAttribute(eq("recipes"), anySet());
  }

  @Test
  public void testMockMVC() throws Exception {
    MockMvc mockMVC = MockMvcBuilders.standaloneSetup(this.indexController).build();

    mockMVC.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(view().name("index"));
  }
}
