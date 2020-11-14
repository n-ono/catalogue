package railway.catalogue.domain.common;

import lombok.*;

/**
 * 料金
 * 10 円未満は切り捨てる
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Amount {
  @Getter private final int value;

  public static Amount from(int value) {
    return new Amount(adjust(value));
  }

  private static int adjust(int value) {
    return (int) Math.floor(value / 10) * 10;
  }
}
