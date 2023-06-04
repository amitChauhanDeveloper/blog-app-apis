/*
 * This file is generated by jOOQ.
 */
package com.codewithamit.jooq.tables;


import com.codewithamit.jooq.BlogAppApis;
import com.codewithamit.jooq.Keys;
import com.codewithamit.jooq.tables.records.PostsRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Posts extends TableImpl<PostsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>blog-app-apis.posts</code>
     */
    public static final Posts POSTS = new Posts();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PostsRecord> getRecordType() {
        return PostsRecord.class;
    }

    /**
     * The column <code>blog-app-apis.posts.postId</code>.
     */
    public final TableField<PostsRecord, Integer> POSTID = createField(DSL.name("postId"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>blog-app-apis.posts.addedDate</code>.
     */
    public final TableField<PostsRecord, LocalDateTime> ADDEDDATE = createField(DSL.name("addedDate"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>blog-app-apis.posts.content</code>.
     */
    public final TableField<PostsRecord, String> CONTENT = createField(DSL.name("content"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>blog-app-apis.posts.imageName</code>.
     */
    public final TableField<PostsRecord, String> IMAGENAME = createField(DSL.name("imageName"), SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>blog-app-apis.posts.post_title</code>.
     */
    public final TableField<PostsRecord, String> POST_TITLE = createField(DSL.name("post_title"), SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>blog-app-apis.posts.category_id</code>.
     */
    public final TableField<PostsRecord, Integer> CATEGORY_ID = createField(DSL.name("category_id"), SQLDataType.INTEGER, this, "");

    /**
     * The column <code>blog-app-apis.posts.user_id</code>.
     */
    public final TableField<PostsRecord, Integer> USER_ID = createField(DSL.name("user_id"), SQLDataType.INTEGER, this, "");

    private Posts(Name alias, Table<PostsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Posts(Name alias, Table<PostsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>blog-app-apis.posts</code> table reference
     */
    public Posts(String alias) {
        this(DSL.name(alias), POSTS);
    }

    /**
     * Create an aliased <code>blog-app-apis.posts</code> table reference
     */
    public Posts(Name alias) {
        this(alias, POSTS);
    }

    /**
     * Create a <code>blog-app-apis.posts</code> table reference
     */
    public Posts() {
        this(DSL.name("posts"), null);
    }

    public <O extends Record> Posts(Table<O> child, ForeignKey<O, PostsRecord> key) {
        super(child, key, POSTS);
    }

    @Override
    public Schema getSchema() {
        return BlogAppApis.BLOG_APP_APIS;
    }

    @Override
    public Identity<PostsRecord, Integer> getIdentity() {
        return (Identity<PostsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<PostsRecord> getPrimaryKey() {
        return Keys.KEY_POSTS_PRIMARY;
    }

    @Override
    public List<UniqueKey<PostsRecord>> getKeys() {
        return Arrays.<UniqueKey<PostsRecord>>asList(Keys.KEY_POSTS_PRIMARY);
    }

    @Override
    public List<ForeignKey<PostsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PostsRecord, ?>>asList(Keys.FKIJNWR3BRS8VAOSL80JG9RP7UC, Keys.FK5LIDM6CQBC7U4XHQPXM898QME);
    }

    private transient Categories _categories;
    private transient Users _users;

    public Categories categories() {
        if (_categories == null)
            _categories = new Categories(this, Keys.FKIJNWR3BRS8VAOSL80JG9RP7UC);

        return _categories;
    }

    public Users users() {
        if (_users == null)
            _users = new Users(this, Keys.FK5LIDM6CQBC7U4XHQPXM898QME);

        return _users;
    }

    @Override
    public Posts as(String alias) {
        return new Posts(DSL.name(alias), this);
    }

    @Override
    public Posts as(Name alias) {
        return new Posts(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Posts rename(String name) {
        return new Posts(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Posts rename(Name name) {
        return new Posts(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, LocalDateTime, String, String, String, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
