package dto;

import com.casestudy.model.customer.CustomerType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CustomerDTO {
    private Long id;

    private CustomerType customerType;

    @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "{Name}")
    private String name;

    @NotBlank(message = "{NotBlank}")
    private String dateOfBirth;

    @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "^\\d{9}$",message = "{IdCard}")
    private String idCard;

    @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "[0-9]{10}",message = "{PhoneNumber}")
    private String phoneNumber;

    private boolean gender;

    @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "{Email}")
    private String email;

    @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "^[0-9]{1,3}[ ]\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",message = "{Address}")
    private String address;

    public CustomerDTO() {
    }

    public CustomerDTO(Long id, CustomerType customerType, @NotBlank(message = "{NotBlank}")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "{Name}") String name,
                       @NotBlank(message = "{NotBlank}") String dateOfBirth,
                       @NotBlank(message = "{NotBlank}")
                       @Pattern(regexp = "^\\d{9}$", message = "{IdCard}") String idCard,
                       @NotBlank(message = "{NotBlank}")
                       @Pattern(regexp = "(((\\+|)84)|0)(3|5|7|8|9)+([0-9]{8})",
                               message = "{PhoneNumber}") String phoneNumber, boolean gender,
                       @NotBlank(message = "{NotBlank}")
                       @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
                               message = "{Email}") String email,
                       @NotBlank(message = "{NotBlank}")
                       @Pattern(regexp = "^[0-9]{1,3}[ ]\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$",
                               message = "{Address}") String address) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.email = email;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
