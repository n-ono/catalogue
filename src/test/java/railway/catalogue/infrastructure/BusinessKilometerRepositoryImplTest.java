package railway.catalogue.infrastructure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import railway.catalogue.domain.BusinessKilometerRepository;
import railway.catalogue.domain.common.BusinessKilometer;
import railway.catalogue.domain.common.Destination;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BusinessKilometerRepositoryImplTest {
  @Autowired private BusinessKilometerRepository repository;

  static Stream<Arguments> businessKilometerReferenceProvider() {
    return Stream.of(
        Arguments.of(Destination.SHINOSAKA, BusinessKilometer.from(553)),
        Arguments.of(Destination.HIMEJI, BusinessKilometer.from(644)));
  }

  @ParameterizedTest
  @MethodSource("businessKilometerReferenceProvider")
  public void findBy(Destination destination, BusinessKilometer expected) {
    assertEquals(expected, repository.findBy(destination));
  }
}
