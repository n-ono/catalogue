package railway.catalogue.infrastructure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import railway.catalogue.domain.BasicFareRepository;
import railway.catalogue.domain.common.Amount;
import railway.catalogue.domain.common.Destination;
import railway.catalogue.domain.common.FixtureAmountValue;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BasicFareRepositoryImplTest {
  @Autowired private BasicFareRepository repository;

  static Stream<Arguments> fareReferenceProvider() {
    return Stream.of(
        Arguments.of(Destination.SHINOSAKA, FixtureAmountValue.get(8090)),
        Arguments.of(Destination.HIMEJI, FixtureAmountValue.get(10010)));
  }

  @ParameterizedTest
  @MethodSource("fareReferenceProvider")
  public void findBy(Destination destination, Amount expected) {
    assertEquals(expected, repository.findBy(destination));
  }
}
