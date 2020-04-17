package ro.botolanvlad.APBDOO.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class AbstractAuditable {

    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @Column(updatable = false)
    @CreatedDate
    protected LocalDateTime createdAt;

    @LastModifiedDate
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    protected LocalDateTime updatedAt;
}
