import React from 'react';
import { Form, Input, Button } from 'antd';
import useStudentForm from '../../queries/useStudentForm.ts';  // Import the newly created hook
import { StudentFormValues } from './StudentFormTypes.ts';  // Import the newly created types
import './StudentForm.css';

const StudentForm: React.FC = () => {
    const [form] = Form.useForm<StudentFormValues>();
    const { mutate: submitStudentForm, isLoading } = useStudentForm();

    const handleSubmit = (values: StudentFormValues) => {
        submitStudentForm(values, {
            onSettled: () => {
                form.resetFields();
            }
        });
    };

    return (
        <div className="studentFormContainer">
            <Form
                name="studentForm"
                form={form}
                onFinish={handleSubmit}
                initialValues={{
                    studentName: '',
                    studentAge: 0,
                    address: '',
                }}
            >
                <Form.Item
                    name="studentName"
                    label="Student Name"
                    rules={[
                        {
                            required: true,
                            message: 'Please enter the student name!',
                        },
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item
                    name="studentAge"
                    label="Student Age"
                    rules={[
                        {
                            required: true,
                            message: 'Please enter the student age!',
                        },
                        {
                            pattern: /^[0-9]*$/,
                            message: 'Age must be a number!',
                        },
                    ]}
                >
                    <Input type="number" />
                </Form.Item>

                <Form.Item
                    name="address"
                    label="Address"
                    rules={[
                        {
                            required: true,
                            message: 'Please enter the address!',
                        },
                    ]}
                >
                    <Input />
                </Form.Item>

                <Form.Item>
                    <Button type="primary" htmlType="submit" loading={isLoading}>
                        Save
                    </Button>
                </Form.Item>
            </Form>
        </div>
    );
};

export default StudentForm;