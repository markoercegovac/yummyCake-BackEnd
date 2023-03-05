package yummy.cake.com.enums;

public enum RoleEnum {
    ROLE_CUSTOMER("ROLE_CUSTOMER"),
    ROLE_OWNER("ROLE_OWNER");

    public final String value;

    RoleEnum(String value){
        this.value = value;
    }

}
