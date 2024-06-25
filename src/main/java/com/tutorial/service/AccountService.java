package com.tutorial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import com.tutorial.persistence.entity.AccountEntity;
import com.tutorial.persistence.repository.AccountRepo;

@Service
public class AccountService {

  @Autowired
  AccountRepo accountRepo;

  @Autowired
  PasswordEncoder passwordEncoder;

  /**
   * 新增帳號
   * @param account account data
   * @return AccountEntity
   */
  public AccountEntity createAccount(AccountEntity account){
    account.setPwd(passwordEncoder.encode(account.getPwd()));
    return accountRepo.save(account);
  }

  /**
   * 新增帳號
   * @param account account data
   * @return AccountEntity
   */
  public AccountEntity getAccount(AccountEntity account){
    account.setPwd(passwordEncoder.encode(account.getPwd()));
    return accountRepo.save(account);
  }

  /**
   * 取得單一帳號
   * @param id account id
   * @return AccountEntity
   */
  public AccountEntity getAccount(long id){
    return accountRepo.findById(id).orElse(null);
  }

  /**
   * 取得所有帳號
   * @return List<AccountEntity>
   */
  public List<AccountEntity> getAccounts(){
    return accountRepo.findAll();
  }


}
