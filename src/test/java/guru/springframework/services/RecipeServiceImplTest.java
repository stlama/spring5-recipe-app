package guru.springframework.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class RecipeServiceImplTest {

  @Mock
  private RecipeRepository recipeRepository;

  private RecipeService recipeService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);

    this.recipeService = new RecipeServiceImpl(this.recipeRepository);
  }

  @Test
  public void getRecipes() {
    Recipe recipe = new Recipe();
    HashSet<Recipe> recipeData = new HashSet<>();
    recipeData.add(recipe);
    when(this.recipeService.getRecipes()).thenReturn(recipeData);

    Set<Recipe> recipes = this.recipeService.getRecipes();

    assertEquals(1, recipes.size());
    verify(this.recipeRepository, times(1)).findAll();
  }
}
