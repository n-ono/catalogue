package railway.catalogue.domain.common;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmountTest {
  @ParameterizedTest
  @CsvSource({"10010, 10010", "10011, 10010"})
  public void adjust(int src, int expectedAmount) {
    assertEquals(Amount.from(expectedAmount), FixtureAmountValue.get(src));
  }
}
