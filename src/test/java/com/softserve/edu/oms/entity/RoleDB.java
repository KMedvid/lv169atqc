package com.softserve.edu.oms.entity;

public class RoleDB implements IEntity {

    public static enum RoleDBQueries {
        //GET_ROLE_BY_ID("SELECT ID, RoleName FROM dbo.Roles WHERE ID = '%s';"),
        //GET_ROLE_BY_PARTIAL_ROLE_NAME("SELECT ID, RoleName FROM dbo.Roles WHERE RoleName LIKE '%s%%';"),
        INSERT("INSERT INTO dbo.Roles (RoleName) VALUES ('%s');"),
        GET_BY_ID("SELECT ID, RoleName FROM dbo.Roles WHERE ID = '%s';"),
        GET_BY_FIELD("SELECT ID, RoleName FROM dbo.Roles WHERE %s = '%s';"),
        GET_ALL("SELECT ID, RoleName FROM dbo.Roles;"),
        UPDATE_BY_FIELD("UPDATE dbo.Roles SET %s = '%s';"),
        DELETE_BY_ID("DELETE dbo.Roles WHERE ID='%s';");
        private String query;

        private RoleDBQueries(String query) {
            this.query = query;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long id;
    private String roleName;        // May be null

    public RoleDB(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;   // May be null
    }

    // setters - - - - -

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    // getters - - - - -

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

}
