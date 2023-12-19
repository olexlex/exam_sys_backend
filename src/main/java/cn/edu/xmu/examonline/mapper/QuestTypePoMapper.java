package cn.edu.xmu.examonline.mapper;

import cn.edu.xmu.examonline.model.po.QuestTypePo;
import cn.edu.xmu.examonline.model.po.QuestTypePoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestTypePoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest_type
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest_type
     *
     * @mbggenerated
     */
    int insert(QuestTypePo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest_type
     *
     * @mbggenerated
     */
    int insertSelective(QuestTypePo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest_type
     *
     * @mbggenerated
     */
    List<QuestTypePo> selectByExample(QuestTypePoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest_type
     *
     * @mbggenerated
     */
    QuestTypePo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest_type
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") QuestTypePo record, @Param("example") QuestTypePoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest_type
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") QuestTypePo record, @Param("example") QuestTypePoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(QuestTypePo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table quest_type
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(QuestTypePo record);
}