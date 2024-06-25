package com.tutorial.persistence.entity;


import org.hibernate.annotations.Comment;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "accounts")
@org.hibernate.annotations.Comment("帳號資料表")
public class AccountEntity {
  //@GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Comment("ID")
  private Long id;

  @Comment("帳號")
  private String account;

  @Comment("密碼")
  private String pwd;

  @Comment("權限")
  private String authority;
}
