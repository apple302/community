package com.apple.shen.community.mapper;

import com.apple.shen.community.model.User;
import com.apple.shen.community.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    List<User> selectByExampleWithRowbounds(UserExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    User selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USER
     *
     * @mbg.generated Mon Dec 02 19:33:14 CST 2019
     */
    int updateByPrimaryKey(User record);
}