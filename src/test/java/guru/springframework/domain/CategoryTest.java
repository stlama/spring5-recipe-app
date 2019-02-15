package guru.springframework.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

  private Category category;

  @Before
  public void setUp() {
    this.category = new Category();
  }

  @Test
  public void getId() {
    Long idValue = 4L;

    this.category.setId(idValue);

    assertEquals(idValue, this.category.getId());
  }
}
