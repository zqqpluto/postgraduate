package cn.pluto.postgraduate.dao;

import cn.pluto.postgraduate.pojo.Excelpath;
import cn.pluto.postgraduate.pojo.ExcelpathExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExcelpathMapper {
    int countByExample(ExcelpathExample example);

    int deleteByExample(ExcelpathExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Excelpath record);

    int insertSelective(Excelpath record);

    List<Excelpath> selectByExample(ExcelpathExample example);

    Excelpath selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Excelpath record, @Param("example") ExcelpathExample example);

    int updateByExample(@Param("record") Excelpath record, @Param("example") ExcelpathExample example);

    int updateByPrimaryKeySelective(Excelpath record);

    int updateByPrimaryKey(Excelpath record);
}