package guru.springframework.repositories;

import static org.junit.Assert.assertEquals;

import guru.springframework.domain.UnitOfMeasure;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryITest {

  @Autowired
  private UnitOfMeasureRepository unitOfMeasureRepository;

  @Before
  public void setUp() {

  }

  @Test
  public void findByDescription() {
    Optional<UnitOfMeasure> optionalUnit = this.unitOfMeasureRepository.findByDescription("Teaspoon");

    assertEquals("Teaspoon", optionalUnit.get().getDescription());
  }

  @Test
  public void findByDescriptionCup() {
    Optional<UnitOfMeasure> optionalUnit = this.unitOfMeasureRepository.findByDescription("Cup");

    assertEquals("Cup", optionalUnit.get().getDescription());
  }
}
