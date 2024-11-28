import {Component, OnInit} from '@angular/core';
import {MessagesService} from "../../services/messages.service";
import {Message} from "../../models/Message";
import {MatDialog} from "@angular/material/dialog";
import {MessageDetailComponent} from "../message-detail/message-detail.component";

@Component({
  selector: 'app-list-messages',
  templateUrl: './list-messages.component.html',
  styleUrls: ['./list-messages.component.css']
})
export class ListMessagesComponent implements OnInit{
  messages: Message[] = [];
  currentPage: number = 0;
  pageSize: number = 5;
  totalMessages: number = 0;
  displayedColumns: string[] = ['id', 'content', 'status', 'receivedAt'];

  constructor(private dialog: MatDialog, private messageService: MessagesService) {}

  ngOnInit(): void {
    this.loadMessages();
  }

  loadMessages(): void {
    this.messageService.getMessages(this.currentPage, this.pageSize)
      .subscribe((data:any) => {
        this.messages = data.messages;
        this.totalMessages = data.total;
      });
  }

  onPageChange(page: number): void {
    this.currentPage = page;
    this.loadMessages();
  }

  showMessageDetails(message: Message): void {
    this.dialog.open(MessageDetailComponent, {
      data: { message }
    });
  }
}
