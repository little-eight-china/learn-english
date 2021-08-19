package bdbk.learn.controller;

import bdbk.learn.mapper.DictionaryMapper;
import bdbk.learn.model.Dictionary;
import bdbk.learn.model.ResponseVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author little_eight
 * @since 2021/8/17
 */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryMapper mapper;

    @GetMapping("/list")
    public ResponseVo list(@RequestParam(value = "dictionarySpell") String dictionarySpell,
                           @RequestParam(value = "size") Integer size) {
        if(Strings.isEmpty(dictionarySpell)) {
            return ResponseVo.error("9999", "单词不允许为空");
        }
        List<Dictionary> resultList;
        resultList = mapper.selectAllByDictionarySpell(dictionarySpell, "cet4", size);


        return ResponseVo.success(resultList);
    }

}
