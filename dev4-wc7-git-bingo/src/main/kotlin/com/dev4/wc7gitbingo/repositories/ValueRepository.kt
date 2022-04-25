package com.dev4.wc7gitbingo.repositories

import com.dev4.wc7gitbingo.models.Value
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ValueRepository : JpaRepository<Value, Long> {

}