package railway.catalogue.domain.common;

import lombok.*;

/**
 * 営業キロ
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BusinessKilometer {
  @Getter private final int value;

  public static BusinessKilometer from(int value) {
    return new BusinessKilometer(value);
  }
}
