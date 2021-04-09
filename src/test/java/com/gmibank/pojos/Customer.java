package com.gmibank.pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "firstName",
        "lastName",
        "middleInitial",
        "email",
        "mobilePhoneNumber",
        "phoneNumber",
        "zipCode",
        "address",
        "city",
        "ssn",
        "createDate",
        "zelleEnrolled",
        "country",
        "state",
        "user",
        "accounts"
})
public class Customers {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("middleInitial")
    private String middleInitial;
    @JsonProperty("email")
    private String email;
    @JsonProperty("mobilePhoneNumber")
    private String mobilePhoneNumber;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("zipCode")
    private String zipCode;
    @JsonProperty("address")
    private String address;
    @JsonProperty("city")
    private String city;
    @JsonProperty("ssn")
    private String ssn;
    @JsonProperty("createDate")
    private String createDate;
    @JsonProperty("zelleEnrolled")
    private Boolean zelleEnrolled;
    @JsonProperty("country")
    private Country country;
    @JsonProperty("state")
    private String state;
    @JsonProperty("user")
    private User user;
    @JsonProperty("accounts")
    private List<Accounts> accounts = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Customers() {
    }

    /**
     *
     * @param lastName
     * @param mobilePhoneNumber
     * @param zipCode
     * @param country
     * @param address
     * @param city
     * @param zelleEnrolled
     * @param ssn
     * @param firstName
     * @param middleInitial
     * @param phoneNumber
     * @param id
     * @param state
     * @param accounts
     * @param user
     * @param email
     * @param createDate
     */
    public Customers(Integer id, String firstName, String lastName, String middleInitial, String email, String mobilePhoneNumber, String phoneNumber, String zipCode, String address, String city, String ssn, String createDate, Boolean zelleEnrolled, Country country, String state, User user, List<Accounts> accounts) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
        this.address = address;
        this.city = city;
        this.ssn = ssn;
        this.createDate = createDate;
        this.zelleEnrolled = zelleEnrolled;
        this.country = country;
        this.state = state;
        this.user = user;
        this.accounts=accounts;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("firstName")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonProperty("lastName")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("lastName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonProperty("middleInitial")
    public String getMiddleInitial() {
        return middleInitial;
    }

    @JsonProperty("middleInitial")
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("mobilePhoneNumber")
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    @JsonProperty("mobilePhoneNumber")
    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    @JsonProperty("phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @JsonProperty("phoneNumber")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonProperty("zipCode")
    public String getZipCode() {
        return zipCode;
    }

    @JsonProperty("zipCode")
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("ssn")
    public String getSsn() {
        return ssn;
    }

    @JsonProperty("ssn")
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @JsonProperty("createDate")
    public String getCreateDate() {
        return createDate;
    }

    @JsonProperty("createDate")
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @JsonProperty("zelleEnrolled")
    public Boolean getZelleEnrolled() {
        return zelleEnrolled;
    }

    @JsonProperty("zelleEnrolled")
    public void setZelleEnrolled(Boolean zelleEnrolled) {
        this.zelleEnrolled = zelleEnrolled;
    }

    @JsonProperty("country")
    public Country getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(Country country) {
        this.country = country;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("accounts")
    public List<Accounts> getAccounts() {
        return accounts;
    }

    @JsonProperty("accounts")
    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", ssn='" + ssn + '\'' +
                ", createDate='" + createDate + '\'' +
                ", zelleEnrolled=" + zelleEnrolled +
                ", country=" + country +
                ", state='" + state + '\'' +
                ", user=" + user +
                ", accounts=" + accounts +
                '}';
    }
}