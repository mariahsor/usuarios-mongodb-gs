package com.gruposalinas.usuarios_mongodb.dto;

import com.gruposalinas.usuarios_mongodb.util.Meta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ApiResponseDTO
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(
        chain  = true,
        fluent = false
)
public class ApiResponseDTO {

    private Meta meta;
    private Object data;

}
