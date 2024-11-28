import {Component, OnInit, ViewChild} from '@angular/core';
import {MessagesService} from "../../services/messages.service";
import {Message} from "../../models/Message";
import {MatDialog} from "@angular/material/dialog";
import {MessageDetailComponent} from "../message-detail/message-detail.component";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-list-messages',
  templateUrl: './list-messages.component.html',
  styleUrls: ['./list-messages.component.css']
})
export class ListMessagesComponent implements OnInit{
  displayedColumns: string[] = ['id', 'content', 'status', 'receivedAt'];
  messages: Message[] = [];
  currentPage: number = 0;
  pageSize: number = 5;
  totalMessages: number = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  dataSource: MatTableDataSource<any> = new MatTableDataSource();
  constructor(private dialog: MatDialog, private messageService: MessagesService) {}

  ngOnInit(): void {
    this.loadMessages();
  }

  loadMessages(): void {
    this.messageService.getMessages(this.currentPage, this.pageSize)
      .subscribe((data:any) => {
        this.totalMessages = data.totalElements;
        this.dataSource.data = data.content;
      });
  }

  onPageChange(event: PageEvent): void {
    this.currentPage = event.pageIndex;
    this.pageSize = event.pageSize;
    this.loadMessages();
  }

  showMessageDetails(message: Message): void {
    this.dialog.open(MessageDetailComponent, {
      data: { message }
    });
  }
}
