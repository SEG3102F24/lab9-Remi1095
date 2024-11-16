package seg3x02.tempconverterapi

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.Customizer
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { auth -> auth.anyRequest().authenticated() }.httpBasic(Customizer.withDefaults())
        return http.build()
    }


    @Bean
    fun userDetailsService(): UserDetailsService {
        val encoder = passwordEncoder()

        val user1Password = encoder.encode("pass1")
        val user2Password = encoder.encode("pass2")

        val user1: UserDetails = User.withUsername("user1")
            .password(user1Password)
            .roles("USER")
            .build()

        val user2: UserDetails = User.withUsername("user2")
            .password(user2Password)
            .roles("USER")
            .build()

        return InMemoryUserDetailsManager(user1, user2)
    }
    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
}
