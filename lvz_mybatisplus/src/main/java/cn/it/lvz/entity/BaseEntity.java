package cn.it.lvz.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Description:
 * Define a  {@code BaseEntity} implementations .
 *
 * @author: flz
 * @date: 2019/4/18
 */
@Data
@Accessors(chain = true)
public class BaseEntity implements Serializable {
    private Long id;
}
