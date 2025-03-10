/*
 * This file is generated by jOOQ.
 */
package generated.jooq.tables;


import generated.jooq.DefaultSchema;
import generated.jooq.Keys;
import generated.jooq.tables.Organisation.OrganisationPath;
import generated.jooq.tables.SubContainer.SubContainerPath;
import generated.jooq.tables.records.ContainerRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.InverseForeignKey;
import org.jooq.Name;
import org.jooq.Path;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.Record;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
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
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Container extends TableImpl<ContainerRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>container</code>
     */
    public static final Container CONTAINER = new Container();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ContainerRecord> getRecordType() {
        return ContainerRecord.class;
    }

    /**
     * The column <code>container.id</code>.
     */
    public final TableField<ContainerRecord, String> ID = createField(DSL.name("id"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>container.container_name</code>.
     */
    public final TableField<ContainerRecord, String> CONTAINER_NAME = createField(DSL.name("container_name"), SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>container.created_at</code>.
     */
    public final TableField<ContainerRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>container.updated_at</code>.
     */
    public final TableField<ContainerRecord, LocalDateTime> UPDATED_AT = createField(DSL.name("updated_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>container.organisation_id</code>.
     */
    public final TableField<ContainerRecord, String> ORGANISATION_ID = createField(DSL.name("organisation_id"), SQLDataType.VARCHAR(255), this, "");

    private Container(Name alias, Table<ContainerRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Container(Name alias, Table<ContainerRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>container</code> table reference
     */
    public Container(String alias) {
        this(DSL.name(alias), CONTAINER);
    }

    /**
     * Create an aliased <code>container</code> table reference
     */
    public Container(Name alias) {
        this(alias, CONTAINER);
    }

    /**
     * Create a <code>container</code> table reference
     */
    public Container() {
        this(DSL.name("container"), null);
    }

    public <O extends Record> Container(Table<O> path, ForeignKey<O, ContainerRecord> childPath, InverseForeignKey<O, ContainerRecord> parentPath) {
        super(path, childPath, parentPath, CONTAINER);
    }

    /**
     * A subtype implementing {@link Path} for simplified path-based joins.
     */
    public static class ContainerPath extends Container implements Path<ContainerRecord> {

        private static final long serialVersionUID = 1L;
        public <O extends Record> ContainerPath(Table<O> path, ForeignKey<O, ContainerRecord> childPath, InverseForeignKey<O, ContainerRecord> parentPath) {
            super(path, childPath, parentPath);
        }
        private ContainerPath(Name alias, Table<ContainerRecord> aliased) {
            super(alias, aliased);
        }

        @Override
        public ContainerPath as(String alias) {
            return new ContainerPath(DSL.name(alias), this);
        }

        @Override
        public ContainerPath as(Name alias) {
            return new ContainerPath(alias, this);
        }

        @Override
        public ContainerPath as(Table<?> alias) {
            return new ContainerPath(alias.getQualifiedName(), this);
        }
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<ContainerRecord> getPrimaryKey() {
        return Keys.CONTAINER_PKEY;
    }

    @Override
    public List<ForeignKey<ContainerRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CONTAINER__FKESG9E8BMX9BNU9557QAMULMO);
    }

    private transient OrganisationPath _organisation;

    /**
     * Get the implicit join path to the <code>organisation</code> table.
     */
    public OrganisationPath organisation() {
        if (_organisation == null)
            _organisation = new OrganisationPath(this, Keys.CONTAINER__FKESG9E8BMX9BNU9557QAMULMO, null);

        return _organisation;
    }

    private transient SubContainerPath _subContainer;

    /**
     * Get the implicit to-many join path to the <code>sub_container</code>
     * table
     */
    public SubContainerPath subContainer() {
        if (_subContainer == null)
            _subContainer = new SubContainerPath(this, null, Keys.SUB_CONTAINER__FKHLIHOPWTTEP2OYMBFUU44XD41.getInverseKey());

        return _subContainer;
    }

    @Override
    public Container as(String alias) {
        return new Container(DSL.name(alias), this);
    }

    @Override
    public Container as(Name alias) {
        return new Container(alias, this);
    }

    @Override
    public Container as(Table<?> alias) {
        return new Container(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Container rename(String name) {
        return new Container(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Container rename(Name name) {
        return new Container(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Container rename(Table<?> name) {
        return new Container(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Container where(Condition condition) {
        return new Container(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Container where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Container where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Container where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Container where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Container where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Container where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Container where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Container whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Container whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
