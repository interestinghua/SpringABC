package com.example.dao02;

import com.example.domain.LearnResource;
import com.example.tools.StringUtil;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
public interface LearnMapperV2 {

    @Insert("insert into learn_resource(author, title,url) values(#{author},#{title},#{url})")
    int add(LearnResource LearnResource);

    @Update("update learn_resource set author=#{author},title=#{title},url=#{url} where id = #{id}")
    int update(LearnResource LearnResource);

    @DeleteProvider(type = LearnSqlBuilder.class, method = "deleteByids")
    int deleteByIds(@Param("ids") String[] ids);

    @Select("select * from learn_resource where id = #{id}")
    @Results(id = "learnMap", value = {
            @Result(column = "id", property = "id", javaType = Long.class),
            @Result(column = "author", property = "author", javaType = String.class),
            @Result(column = "title", property = "title", javaType = String.class)
    })
    LearnResource queryLearnResourceById(@Param("id") Long id);

    @SelectProvider(type = LearnSqlBuilder.class, method = "queryLearnResourceByParams")
    List<LearnResource> queryLearnResourceList(Map<String, Object> params);

    class LearnSqlBuilder {

        public String queryLearnResourceByParams(final Map<String, Object> params) {

            StringBuilder sql = new StringBuilder();

            sql.append("select * from learn_resource where 1=1");

            if (!StringUtil.isNull((String) params.get("author"))) {
                sql.append(" and author like '%").append((String) params.get("author")).append("%'");
            }
            if (!StringUtil.isNull((String) params.get("title"))) {
                sql.append(" and title like '%").append((String) params.get("title")).append("%'");
            }
            System.out.println("查询sql==" + sql.toString());

            return sql.toString();
        }

        //删除的方法
        public String deleteByids(@Param("ids") final String[] ids) {
            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM learn_resource WHERE id in(");

            for (int i = 0; i < ids.length; i++) {
                if (i == ids.length - 1) {
                    sql.append(ids[i]);
                } else {
                    sql.append(ids[i]).append(",");
                }
            }
            sql.append(")");
            return sql.toString();
        }

    }
}
