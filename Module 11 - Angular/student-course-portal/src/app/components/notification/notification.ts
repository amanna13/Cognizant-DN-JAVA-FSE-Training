import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [CommonModule],
  providers: [NotificationService],
  templateUrl: './notification.html',
  styleUrl: './notification.css'
})
export class NotificationComponent {
  constructor(private notificationService: NotificationService) {}

  addNotification(): void {
    this.notificationService.add('New notification from this component instance');
  }

  get messages(): string[] {
    return this.notificationService.getMessages();
  }

  // Component-level providers create a separate NotificationService instance for each NotificationComponent tree.
}