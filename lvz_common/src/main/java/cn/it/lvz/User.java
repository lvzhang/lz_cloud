package cn.it.lvz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 * Define a  {@code User} implementations {@link }.
 *
 * @author: flz
 * @date: 2019/3/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String username;
    private Integer age;

}
