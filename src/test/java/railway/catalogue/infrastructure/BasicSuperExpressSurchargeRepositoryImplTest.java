package railway.catalogue.infrastructure;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import railway.catalogue.domain.BasicSuperExpressSurchargeRepository;
import railway.catalogue.domain.common.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BasicSuperExpressSurchargeRepositoryImplTest {
  @Autowired private BasicSuperExpressSurchargeRepository repository;

  static Stream<Arguments> superExpressSurchargeReferenceProvider() {
    return Stream.of(
        // のぞみ - 自由席 - 新大阪
        Arguments.of(
            TrainType.NOZOMI, SeatType.FREE, Destination.SHINOSAKA, FixtureAmountValue.get(5280)),
        // のぞみ - 自由席 - 姫路
        Arguments.of(
            TrainType.NOZOMI, SeatType.FREE, Destination.HIMEJI, FixtureAmountValue.get(5920)),
        // のぞみ - 指定席 - 新大阪
        Arguments.of(
            TrainType.NOZOMI,
            SeatType.RESERVED,
            Destination.SHINOSAKA,
            FixtureAmountValue.get(5810)),
        // のぞみ - 指定席 - 姫路
        Arguments.of(
            TrainType.NOZOMI, SeatType.RESERVED, Destination.HIMEJI, FixtureAmountValue.get(6450)),
        // ひかり - 自由席 - 新大阪
        Arguments.of(
            TrainType.HIKARI, SeatType.FREE, Destination.SHINOSAKA, FixtureAmountValue.get(4960)),
        // ひかり - 自由席 - 姫路
        Arguments.of(
            TrainType.HIKARI, SeatType.FREE, Destination.HIMEJI, FixtureAmountValue.get(5390)),
        // ひかり - 指定席 - 新大阪
        Arguments.of(
            TrainType.HIKARI,
            SeatType.RESERVED,
            Destination.SHINOSAKA,
            FixtureAmountValue.get(5490)),
        // ひかり - 指定席 - 姫路
        Arguments.of(
            TrainType.HIKARI, SeatType.RESERVED, Destination.HIMEJI, FixtureAmountValue.get(5920)));
  }

  @ParameterizedTest
  @MethodSource("superExpressSurchargeReferenceProvider")
  public void findAmountBy(
      TrainType trainType, SeatType seatType, Destination destination, Amount expected) {
    assertEquals(expected, repository.findBy(trainType, seatType, destination));
  }
}
