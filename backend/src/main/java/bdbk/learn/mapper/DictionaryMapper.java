package bdbk.learn.mapper;

import bdbk.learn.model.Dictionary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author little_eight
 * @since 2021/8/17
 */
public interface DictionaryMapper extends BaseMapper<Dictionary> {


    // 使用mysql
    List<Dictionary> selectAllByDictionarySpell(@Param("dictionarySpell")String dictionarySpell, @Param("dictionaryType")String dictionaryType, @Param("size")Integer size);
}
