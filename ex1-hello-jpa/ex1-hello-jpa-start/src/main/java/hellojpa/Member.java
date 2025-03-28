//package hellojpa;
//
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//
//@Entity
//@SequenceGenerator(
//        name = "member_seq_generator",
//        sequenceName = "member_seq")
////@TableGenerator(
////        name = "MEMBER_SEQ_GENERATOR",
////        table = "MY_SEQUENCES",
////        pkColumnValue = "MEMBER_SEQ",
////        allocationSize = 1
////)
//public class Member {
//
//    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
////    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
//    private Long id;
//
//    @Column(name="name", length = 10)
//    private String name;
//
//    private Integer age;
//
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
//
//    private LocalDate testLocalDate;
//    private LocalDateTime testLocalDateTime;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob
//    private String description;
//
//    public Member() {
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public RoleType getRoleType() {
//        return roleType;
//    }
//
//    public void setRoleType(RoleType roleType) {
//        this.roleType = roleType;
//    }
//
//    public Date getCreateDate() {
//        return createDate;
//    }
//
//    public void setCreateDate(Date createDate) {
//        this.createDate = createDate;
//    }
//
//    public Date getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(Date lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//}
