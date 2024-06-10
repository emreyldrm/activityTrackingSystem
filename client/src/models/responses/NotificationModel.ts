export interface NotificationModel {
	id: number;
	senderId: number;
	recipientId: number;
	eventId: number;
	message: string;
	notificationTime: string;
}