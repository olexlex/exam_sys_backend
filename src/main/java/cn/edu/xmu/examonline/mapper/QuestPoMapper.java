package cn.edu.xmu.examonline.mapper;

import cn.edu.xmu.examonline.model.po.MajorPo;
import cn.edu.xmu.examonline.model.po.QuestPo;
import cn.edu.xmu.examonline.model.po.QuestPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestPoMapper {

    List<QuestPo> selectAll();

    List<QuestPo> selectByMajorId(int id);

    List<QuestPo> selectByPaperId(int id);


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    int insert(QuestPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    int insertSelective(QuestPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    List<QuestPo> selectByExample(QuestPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    QuestPo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") QuestPo record, @Param("example") QuestPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") QuestPo record, @Param("example") QuestPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(QuestPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(QuestPo record);
}