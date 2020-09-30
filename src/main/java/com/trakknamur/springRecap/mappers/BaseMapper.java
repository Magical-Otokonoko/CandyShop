package com.trakknamur.springRecap.mappers;

public interface BaseMapper<TENTITY, TFORM, TDTO> {
    TENTITY fromFormToEntity(TFORM form);
    TDTO toDto(TENTITY entity);
    TENTITY toEntity(TDTO dto);
}
