package TheProductDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDto {

     public long id;
    public  String name;
   public  float price;
  public  String description;
   public  Byte categoryId;
}
