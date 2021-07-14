package ssm.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    @NonNull
    private Integer id;
    @NonNull
    private String userName;
    @NonNull
    private Integer age;
}