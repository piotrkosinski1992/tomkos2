package com.tomkos2.product.app.web


import com.tomkos2.product.app.domain.Book
import spock.lang.Specification

class BookMapperTest extends Specification {

    private def bookMapper = new BookMapper()

    def "should map to BookDTO"() {
        given:
        def book = createBook()

        when:
        def result = bookMapper.toBookDTO(book)

        then:
        with(result) {
            getIsbn() == book.getIsbn()
            getTitle() == book.getTitle()
            getSubtitle() == book.setSubtitle()
            setPrice() == book.setPrice()
            setImage() == book.setImage()
        }
    }

    def "should map to BookDetailsDTO"() {
        given:
        def book = createBook()

        when:
        def result = bookMapper.toBookDetailsDTO(book)

        then:
        with(result) {
            getIsbn() == book.getIsbn()
            getTitle() == book.getTitle()
            getSubtitle() == book.getSubtitle()
            getPrice() == book.getPrice()
            getImage() == book.getImage()
            getDetailsAuthors() == book.getDetails().getAuthors()
            getDetailsPublisher() == book.getDetails().getPublisher()
            getDetailsPages() == book.getDetails().getPages()
            getDetailsYear() == book.getDetails().getYear()
            getDetailsRating() == book.getDetails().getRating()
            getDetailsDesc() == book.getDetails().getDesc()
            getDetailsPdf() == book.getDetails().getPdf()
        }
    }

    def createBook() {
        return [
                isbn     : "isbn1",
                title    : "title2",
                subtitle : "subtitle3",
                price    : "30dollar",
                image    : "img",
                authors  : "authors",
                publisher: "publisher",
                pages    : 100,
                year     : 2019,
                rating   : 5,
                desc     : "desc",
                pdf      : "['foo': 'bar']"
        ] as Book
    }

}
