package com.tomkos2.monolith.app.user.gateway;

import com.tomkos2.monolith.app.user.domain.EntityId;
import com.tomkos2.monolith.app.user.domain.UserInfo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, EntityId> {

  Optional<UserInfo> findByCredentialsUsername(String username);
}
