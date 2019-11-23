package cn.pluto.postgraduate.dao;

import cn.pluto.postgraduate.pojo.Modelpath;
import cn.pluto.postgraduate.pojo.ModelpathExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ModelpathMapper {
    int countByExample(ModelpathExample example);

    int deleteByExample(ModelpathExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Modelpath record);

    int insertSelective(Modelpath record);

    List<Modelpath> selectByExample(ModelpathExample example);

    Modelpath selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Modelpath record, @Param("example") ModelpathExample example);

    int updateByExample(@Param("record") Modelpath record, @Param("example") ModelpathExample example);

    int updateByPrimaryKeySelective(Modelpath record);

    int updateByPrimaryKey(Modelpath record);
}