/*
 * This file is generated by jOOQ.
 */
package generated.jooq.tables.records;


import generated.jooq.tables.Organisation;

import java.time.LocalDateTime;

import org.jooq.Record1;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class OrganisationRecord extends UpdatableRecordImpl<OrganisationRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>organisation.id</code>.
     */
    public OrganisationRecord setId(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>organisation.id</code>.
     */
    public String getId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>organisation.created_at</code>.
     */
    public OrganisationRecord setCreatedAt(LocalDateTime value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>organisation.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>organisation.organisation_name</code>.
     */
    public OrganisationRecord setOrganisationName(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>organisation.organisation_name</code>.
     */
    public String getOrganisationName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>organisation.updated_at</code>.
     */
    public OrganisationRecord setUpdatedAt(LocalDateTime value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>organisation.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OrganisationRecord
     */
    public OrganisationRecord() {
        super(Organisation.ORGANISATION);
    }

    /**
     * Create a detached, initialised OrganisationRecord
     */
    public OrganisationRecord(String id, LocalDateTime createdAt, String organisationName, LocalDateTime updatedAt) {
        super(Organisation.ORGANISATION);

        setId(id);
        setCreatedAt(createdAt);
        setOrganisationName(organisationName);
        setUpdatedAt(updatedAt);
        resetTouchedOnNotNull();
    }

    /**
     * Create a detached, initialised OrganisationRecord
     */
    public OrganisationRecord(generated.jooq.tables.pojos.Organisation value) {
        super(Organisation.ORGANISATION);

        if (value != null) {
            setId(value.getId());
            setCreatedAt(value.getCreatedAt());
            setOrganisationName(value.getOrganisationName());
            setUpdatedAt(value.getUpdatedAt());
            resetTouchedOnNotNull();
        }
    }
}
