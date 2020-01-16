import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {CartService} from '../../../api/cart.service';
import {Location} from '@angular/common';
import {BookDetails} from '../book-details';

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.scss']
})
export class BookDetailsComponent implements OnInit {

  bookDetails: BookDetails;

  constructor(private activatedRoute: ActivatedRoute, private location: Location, private cartService: CartService) {
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe((bookDetails: BookDetails) => {
      this.bookDetails = bookDetails;
    });
  }

  onBuyClick(amount: string) {
    this.cartService.addToCart(this.bookDetails.isbn, amount);
  }

  onBackClick() {
    this.location.back();
  }
}
