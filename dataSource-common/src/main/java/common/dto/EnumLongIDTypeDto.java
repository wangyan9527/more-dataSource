
package common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class EnumLongIDTypeDto {
    long id;
    String name;

    public EnumLongIDTypeDto(EnumService enums) {
        this.id = enums.getValue();
        this.name = enums.getDesc();
    }

}
