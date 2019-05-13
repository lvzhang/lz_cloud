package cn.it.lvz.mapper;

import cn.it.lvz.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 * Define a  {@code UserMapper} implementations .
 *
 * @author: flz
 * @date: 2019/4/18
 */
@Mapper
public interface UserMapper  extends BaseMapper<User> {
}
