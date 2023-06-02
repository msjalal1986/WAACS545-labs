package miu.edu.lab.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class UserDto {
    long id;
    String name;
}