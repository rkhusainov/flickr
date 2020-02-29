package com.khusainov.rinat.flickr.domain.mapper;

/**
 * Интерфейс для маппинга данных
 *
 * @param <From> маппинг из entity
 * @param <To>   маппинг в data
 * @author Хусаинов Ринат on 2019-12-15
 */
public interface IMapper<From, To> {
    To convert(From from);
}
